# 仿真场景存储格式选择指南

## 快速决策树

```
是否需要复杂的层次结构和元数据？
├─ 是 → 是否需要行业标准兼容？
│   ├─ 是 → **使用XML** (如COLLADA, OpenDRIVE)
│   └─ 否 → 是否重视可读性？
│       ├─ 是 → **使用YAML**
│       └─ 否 → **使用XML + 自定义Schema**
└─ 否 → 是否需要高性能？
    ├─ 是 → 是否需要跨语言支持？
    │   ├─ 是 → **使用Protocol Buffers**
    │   └─ 否 → **使用语言特定的二进制格式**
    └─ 否 → **使用JSON**
```

## 详细对比表

| 特性 | XML | JSON | YAML | Protocol Buffers |
|------|-----|------|------|------------------|
| 可读性 | ★★★☆☆ | ★★★★☆ | ★★★★★ | ★☆☆☆☆ |
| 性能 | ★★☆☆☆ | ★★★★☆ | ★★★☆☆ | ★★★★★ |
| 文件大小 | ★★☆☆☆ | ★★★★☆ | ★★★☆☆ | ★★★★★ |
| 表达能力 | ★★★★★ | ★★★☆☆ | ★★★★☆ | ★★★★☆ |
| 验证支持 | ★★★★★ | ★★★☆☆ | ★★☆☆☆ | ★★★★★ |
| 工具支持 | ★★★★★ | ★★★★★ | ★★★★☆ | ★★★★☆ |
| 注释支持 | ✓ | ✗ | ✓ | ✓ |
| 引用支持 | ✓ | ✗ | ✓ | ✗ |

## 典型仿真场景示例

### 1. 自动驾驶仿真（推荐XML）
```xml
<!-- OpenDRIVE格式 -->
<OpenDRIVE>
  <header revMajor="1" revMinor="4" name="Example" version="1.0"/>
  <road name="Road 1" length="100.0" id="1" junction="-1">
    <planView>
      <geometry s="0.0" x="0.0" y="0.0" hdg="0.0" length="100.0">
        <line/>
      </geometry>
    </planView>
  </road>
</OpenDRIVE>
```

### 2. 游戏场景（推荐JSON）
```json
{
  "scene": "city_center",
  "objects": [
    {
      "type": "building",
      "model": "skyscraper_01",
      "transform": {
        "position": [100, 0, 50],
        "rotation": [0, 45, 0],
        "scale": [1, 1, 1]
      }
    }
  ]
}
```

### 3. 机器人仿真（推荐YAML）
```yaml
# ROS仿真场景配置
robot:
  name: mobile_robot
  sensors:
    - type: lidar
      range: 30.0
      resolution: 0.1
    - type: camera
      fov: 90
      resolution: [640, 480]
  actuators:
    - type: differential_drive
      max_velocity: 2.0
      max_acceleration: 1.0
```

## 最佳实践建议

### 1. 分层存储策略
- **静态场景定义**：XML/YAML（场景布局、对象定义）
- **动态运行数据**：JSON/ProtoBuf（位置、状态更新）
- **历史记录**：HDF5/数据库（大量时序数据）

### 2. 版本控制友好
- 优先选择文本格式（XML/JSON/YAML）
- 保持格式化一致性
- 分离配置和数据

### 3. 性能优化
- 大文件考虑分块加载
- 使用压缩（gzip）
- 考虑缓存策略

## 结论

对于仿真场景存储，建议：

1. **默认选择JSON**：简单、通用、性能均衡
2. **复杂场景用XML**：需要严格验证、复杂结构
3. **配置文件用YAML**：人工编辑频繁的场景
4. **性能关键用ProtoBuf**：实时仿真、大规模数据

记住：**没有绝对最好的格式，只有最适合的格式**。根据你的具体需求选择。